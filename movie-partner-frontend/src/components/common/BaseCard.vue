<script setup lang="ts">
interface Props {
  title?: string
  loading?: boolean
  bordered?: boolean
  hoverable?: boolean
}

withDefaults(defineProps<Props>(), {
  bordered: true,
  hoverable: false,
})
</script>

<template>
  <a-card
    v-bind="$attrs"
    :title="title"
    :loading="loading"
    :bordered="bordered"
    :hoverable="hoverable"
    class="base-card"
  >
    <slot />
    <template v-if="$slots.extra" #extra>
      <slot name="extra" />
    </template>
    <template v-if="$slots.title" #title>
      <slot name="title" />
    </template>
  </a-card>
</template>

<style scoped>
.base-card {
  border-radius: var(--radius-lg);
  box-shadow: var(--shadow-sm);
  border-color: var(--color-border-light);
  overflow: hidden;
}

.base-card :deep(.ant-card-head) {
  background: var(--color-bg-subtle);
  border-bottom-color: var(--color-border-light);
  font-weight: var(--font-weight-medium);
}

.base-card :deep(.ant-card-body) {
  padding: var(--spacing-lg);
}
</style>
