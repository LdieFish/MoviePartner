import { API_BASE_URL } from '@/config/env'

/** COS 公网访问域名，用于补全相对路径封面 */
export const COS_HOST =
  import.meta.env.VITE_COS_HOST || '桶地址'

const IMAGE_EXT_PATTERN = /\.(jpg|jpeg|png|gif|webp|svg|bmp|ico)(\?.*)?$/i
const PAGE_EXT_PATTERN = /\.(html?|php|asp|aspx|jsp)(\?.*)?$/i
const COS_URL_PATTERN = /\.cos\.[\w-]+\.myqcloud\.com/i
const DOMAIN_PATH_PATTERN = /^[\w.-]+\.[a-z]{2,}(:\d+)?\//i

function looksLikeCosUrl(url: string): boolean {
  return COS_URL_PATTERN.test(url) && url.includes('/')
}

function looksLikeBareDomainUrl(url: string): boolean {
  return DOMAIN_PATH_PATTERN.test(url) && !url.startsWith('http') && !url.startsWith('//')
}

/**
 * 判断是否为可尝试加载的图片地址
 */
export function isValidImageUrl(url?: string | null): boolean {
  if (!url?.trim()) {
    return false
  }

  const trimmed = url.trim()

  if (trimmed.startsWith('data:image/')) {
    return true
  }

  if (trimmed.startsWith('/screenshots/')) {
    return true
  }

  if (trimmed.startsWith('//')) {
    return !PAGE_EXT_PATTERN.test(trimmed)
  }

  if (/^https?:\/\//i.test(trimmed)) {
    if (PAGE_EXT_PATTERN.test(trimmed)) {
      return false
    }
    if (trimmed.endsWith('/')) {
      return false
    }
    if (IMAGE_EXT_PATTERN.test(trimmed)) {
      return true
    }
    if (trimmed.includes('/screenshots/') || looksLikeCosUrl(trimmed)) {
      return true
    }
    return false
  }

  if (trimmed.startsWith('/')) {
    return IMAGE_EXT_PATTERN.test(trimmed) || trimmed.includes('/screenshots/')
  }

  // 无协议前缀的 COS 地址：movie-partner-xxx.cos.ap-beijing.myqcloud.com/screenshots/...
  if (looksLikeCosUrl(trimmed)) {
    return IMAGE_EXT_PATTERN.test(trimmed) || trimmed.includes('/screenshots/')
  }

  if (looksLikeBareDomainUrl(trimmed)) {
    return IMAGE_EXT_PATTERN.test(trimmed) || trimmed.includes('/screenshots/')
  }

  return false
}

/**
 * 规范化图片 URL，兼容绝对地址、协议相对地址、COS 相对路径与站内相对路径
 */
export function normalizeImageUrl(url?: string | null): string {
  if (!url?.trim()) {
    return ''
  }

  let trimmed = url.trim()

  if (trimmed.startsWith('data:')) {
    return trimmed
  }

  if (/^https?:\/\//i.test(trimmed)) {
    return trimmed
  }

  if (trimmed.startsWith('//')) {
    return `https:${trimmed}`
  }

  // 无协议 COS 完整地址
  if (looksLikeCosUrl(trimmed) || looksLikeBareDomainUrl(trimmed)) {
    return `https://${trimmed.replace(/^\/+/, '')}`
  }

  if (trimmed.startsWith('/screenshots/')) {
    const host = COS_HOST.replace(/\/$/, '')
    return `${host}${trimmed}`
  }

  if (trimmed.startsWith('/')) {
    try {
      const base = API_BASE_URL.startsWith('http')
        ? API_BASE_URL
        : `${window.location.origin}${API_BASE_URL}`
      const origin = new URL(base).origin
      return `${origin}${trimmed}`
    } catch {
      return trimmed
    }
  }

  return trimmed
}

/**
 * 获取应用封面展示地址（无效时返回空字符串，由组件显示占位图）
 */
export function getAppCoverUrl(app: Pick<API.AppVO, 'cover'>): string {
  if (!isValidImageUrl(app.cover)) {
    return ''
  }
  return normalizeImageUrl(app.cover)
}

/**
 * 获取用户头像展示地址
 */
export function getUserAvatarUrl(avatar?: string | null): string {
  if (!isValidImageUrl(avatar)) {
    return ''
  }
  return normalizeImageUrl(avatar)
}
