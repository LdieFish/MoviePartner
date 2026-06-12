<template>
  <AppModal v-model:open="visible" title="部署成功" :footer="null" width="600px">
    <div class="deploy-success">
      <div class="success-icon">
        <CheckCircleOutlined class="icon-success" />
      </div>
      <h3>网站部署成功！</h3>
      <p>你的网站已经成功部署，可以通过以下链接访问：</p>
      <div class="deploy-url">
        <a-input :value="deployUrl" readonly>
          <template #suffix>
            <AppButton type="text" @click="handleCopyUrl">
              <CopyOutlined />
            </AppButton>
          </template>
        </a-input>
      </div>
      <div class="deploy-actions">
        <AppButton type="primary" @click="handleOpenSite">访问网站</AppButton>
        <AppButton @click="handleClose">关闭</AppButton>
      </div>
    </div>
  </AppModal>
</template>

<script setup lang="ts">
import { computed } from 'vue'
import { message } from 'ant-design-vue'
import { CheckCircleOutlined, CopyOutlined } from '@ant-design/icons-vue'
import { AppButton, AppModal } from '@/components/common'

interface Props {
  open: boolean
  deployUrl: string
}

interface Emits {
  (e: 'update:open', value: boolean): void
  (e: 'open-site'): void
}

const props = defineProps<Props>()
const emit = defineEmits<Emits>()

const visible = computed({
  get: () => props.open,
  set: (value) => emit('update:open', value),
})

const handleCopyUrl = async () => {
  try {
    await navigator.clipboard.writeText(props.deployUrl)
    message.success('链接已复制到剪贴板')
  } catch (error) {
    console.error('复制失败：', error)
    message.error('复制失败')
  }
}

const handleOpenSite = () => {
  emit('open-site')
}

const handleClose = () => {
  visible.value = false
}
</script>

<style scoped>
.deploy-success {
  text-align: center;
  padding: var(--spacing-lg);
}

.success-icon {
  margin-bottom: var(--spacing-md);
}

.icon-success {
  color: var(--color-success);
  font-size: 48px;
}

.deploy-success h3 {
  margin: 0 0 var(--spacing-md);
  font-size: var(--font-size-lg);
  font-weight: var(--font-weight-semibold);
  color: var(--color-text-primary);
}

.deploy-success p {
  margin: 0 0 var(--spacing-lg);
  color: var(--color-text-secondary);
}

.deploy-url {
  margin-bottom: var(--spacing-lg);
}

.deploy-actions {
  display: flex;
  gap: var(--spacing-sm);
  justify-content: center;
}
</style>
