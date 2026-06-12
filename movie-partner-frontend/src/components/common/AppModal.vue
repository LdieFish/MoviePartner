<script setup lang="ts">
import { computed } from 'vue'

interface Props {
  open: boolean
  title?: string
  width?: string | number
  footer?: unknown
  centered?: boolean
  closable?: boolean
}

interface Emits {
  (e: 'update:open', value: boolean): void
}

const props = withDefaults(defineProps<Props>(), {
  width: '520px',
  centered: true,
  closable: true,
})

const emit = defineEmits<Emits>()

const visible = computed({
  get: () => props.open,
  set: (value) => emit('update:open', value),
})
</script>

<template>
  <a-modal
    v-model:open="visible"
    :title="title"
    :width="width"
    :footer="footer"
    :centered="centered"
    :closable="closable"
    class="app-modal"
    v-bind="$attrs"
  >
    <slot />
    <template v-if="$slots.footer" #footer>
      <slot name="footer" />
    </template>
    <template v-if="$slots.title" #title>
      <slot name="title" />
    </template>
  </a-modal>
</template>

<style scoped>
.app-modal :deep(.ant-modal-content) {
  border-radius: var(--radius-lg);
  overflow: hidden;
}

.app-modal :deep(.ant-modal-header) {
  border-bottom-color: var(--color-border-light);
  padding: var(--spacing-md) var(--spacing-lg);
}

.app-modal :deep(.ant-modal-title) {
  font-weight: var(--font-weight-semibold);
  color: var(--color-text-primary);
}

.app-modal :deep(.ant-modal-body) {
  padding: var(--spacing-md) var(--spacing-lg) var(--spacing-lg);
}

.app-modal :deep(.ant-modal-close) {
  color: var(--color-text-secondary);
}
</style>
