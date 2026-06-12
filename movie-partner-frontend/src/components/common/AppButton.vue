<script setup lang="ts">
defineOptions({ inheritAttrs: false })
</script>

<template>
  <a-button v-bind="$attrs" class="app-button">
    <slot />
  </a-button>
</template>

<style scoped>
.app-button {
  border-radius: var(--radius-md);
  transition: all var(--transition-normal);
}

.app-button:deep(.ant-btn-primary) {
  box-shadow: 0 2px 8px rgba(107, 158, 120, 0.2);
}

.app-button:deep(.ant-btn-primary:hover) {
  box-shadow: 0 4px 12px rgba(107, 158, 120, 0.28);
}
</style>
