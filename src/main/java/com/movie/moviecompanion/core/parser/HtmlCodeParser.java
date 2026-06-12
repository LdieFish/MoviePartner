package com.movie.moviecompanion.core.parser;


import com.movie.moviecompanion.ai.model.HtmlCodeResult;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * HTML 单文件代码解析器
 */
public class HtmlCodeParser implements CodeParser<HtmlCodeResult> {

    private static final Pattern HTML_CODE_PATTERN = Pattern.compile("```html\\s*\\n([\\s\\S]*?)```", Pattern.CASE_INSENSITIVE);

    @Override
    public HtmlCodeResult parseCode(String codeContent) {
        HtmlCodeResult result = new HtmlCodeResult();
        // 优先从 markdown 代码块提取 HTML
        String htmlCode = extractHtmlCode(codeContent);
        if (htmlCode != null && !htmlCode.trim().isEmpty()) {
            result.setHtmlCode(htmlCode.trim());
            return result;
        }
        // 其次识别未包裹代码块的完整 HTML 文档
        String trimmed = codeContent.trim();
        if (HtmlDocumentUtils.isHtmlDocument(trimmed)) {
            result.setHtmlCode(trimmed);
        }
        // 纯文本对话回复不设置 htmlCode，保存阶段会跳过，避免覆盖已有页面
        return result;
    }

    /**
     * 提取 HTML 代码内容
     *
     * @param content 原始内容
     * @return HTML代码
     */
    private String extractHtmlCode(String content) {
        Matcher matcher = HTML_CODE_PATTERN.matcher(content);
        if (matcher.find()) {
            return matcher.group(1);
        }
        return null;
    }
}