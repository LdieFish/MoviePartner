<template>
  <a-layout-footer class="footer">
    <div class="footer-content">
      <p class="copyright">Movie Partner AI 应用生成平台</p>
    </div>
  </a-layout-footer>
</template>

<script setup lang="ts">
// 无需额外的响应式数据
</script>

<style scoped>
.footer {
  background: var(--color-bg-elevated);
  backdrop-filter: var(--backdrop-blur);
  text-align: center;
  padding: var(--spacing-lg);
  margin-top: auto;
  border-top: 1px solid var(--color-border);
  flex-shrink: 0;
}

.copyright {
  margin: 0;
  color: var(--color-text-secondary);
  font-size: var(--font-size-sm);
}
</style>
