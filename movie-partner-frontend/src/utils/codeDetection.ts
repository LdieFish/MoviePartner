import { CodeGenTypeEnum } from './codeGenTypes'

const HTML_CODE_BLOCK = /```html\s[\s\S]*?```/i
const MULTI_FILE_HTML_BLOCK = /```html\s[\s\S]*?```/i

function isHtmlDocument(content: string): boolean {
  const lower = content.toLowerCase()
  return (
    lower.includes('<!doctype html') ||
    lower.includes('<html') ||
    (lower.includes('<head') && lower.includes('<body'))
  )
}

/**
 * 判断 AI 回复是否包含可更新预览的代码
 */
export function shouldRefreshPreview(content: string, codeGenType?: string): boolean {
  const text = content?.trim()
  if (!text) {
    return false
  }

  switch (codeGenType) {
    case CodeGenTypeEnum.MULTI_FILE:
      return MULTI_FILE_HTML_BLOCK.test(text)
    case CodeGenTypeEnum.VUE_PROJECT:
      return (
        text.includes('writeFile') ||
        text.includes('.vue') ||
        text.includes('"path"') ||
        text.includes('ToolExecutedMessage')
      )
    case CodeGenTypeEnum.HTML:
    default:
      return HTML_CODE_BLOCK.test(text) || isHtmlDocument(text)
  }
}
