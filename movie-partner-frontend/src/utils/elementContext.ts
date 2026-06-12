import type { ElementInfo } from './visualEditor'

const ELEMENT_CONTEXT_MARKER = '选中元素信息：'

/**
 * 格式化选中元素上下文（用于展示与拼接到 AI 提示词）
 */
export function formatElementContext(info: ElementInfo): string {
  let text = ELEMENT_CONTEXT_MARKER
  if (info.pagePath) {
    text += `\n- 页面路径: ${info.pagePath}`
  }
  text += `\n- 标签: ${info.tagName.toLowerCase()}`
  text += `\n- 选择器: ${info.selector}`
  if (info.textContent) {
    text += `\n- 当前内容: ${info.textContent.substring(0, 100)}`
  }
  return text
}

/**
 * 将用户输入与元素上下文合并为完整提示词（发送给 AI）
 */
export function appendElementContext(userText: string, info: ElementInfo): string {
  return `${userText}\n\n${formatElementContext(info)}`
}

/**
 * 从历史消息中拆分用户输入与附带元素信息
 */
export function splitUserMessageContent(content: string): {
  userText: string
  elementContext?: string
} {
  const markerIndex = content.indexOf(ELEMENT_CONTEXT_MARKER)
  if (markerIndex === -1) {
    return { userText: content }
  }
  return {
    userText: content.substring(0, markerIndex).trimEnd(),
    elementContext: content.substring(markerIndex).trim(),
  }
}
