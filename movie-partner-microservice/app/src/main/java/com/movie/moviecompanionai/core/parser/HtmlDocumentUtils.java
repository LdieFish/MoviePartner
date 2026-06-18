package com.movie.moviecompanionai.core.parser;

/**
 * HTML 文档识别工具
 */
public final class HtmlDocumentUtils {

    private HtmlDocumentUtils() {
    }

    /**
     * 判断内容是否为可渲染的 HTML 文档（而非普通对话文本）
     */
    public static boolean isHtmlDocument(String content) {
        if (content == null || content.isBlank()) {
            return false;
        }
        String lower = content.toLowerCase();
        return lower.contains("<!doctype html")
                || lower.contains("<html")
                || (lower.contains("<head") && lower.contains("<body"));
    }
}
