<template>
  <div class="app-card" :class="{ 'app-card--featured': featured }">
    <div class="app-preview">
      <img
        v-if="displayCover"
        :src="displayCover"
        :alt="app.appName"
        referrerpolicy="no-referrer"
        @error="handleCoverError"
      />
      <div v-else class="app-placeholder">
        <span>🎬</span>
      </div>
      <div class="app-overlay">
        <a-space>
          <AppButton type="primary" @click="handleViewChat">查看对话</AppButton>
          <AppButton v-if="app.deployKey" type="default" @click="handleViewWork">查看作品</AppButton>
        </a-space>
      </div>
    </div>
    <div class="app-info">
      <div class="app-info-left">
        <a-avatar :src="userAvatar" :size="40">
          {{ app.user?.userName?.charAt(0) || 'U' }}
        </a-avatar>
      </div>
      <div class="app-info-right">
        <h3 class="app-title">{{ app.appName || '未命名应用' }}</h3>
        <p class="app-author">
          {{ app.user?.userName || (featured ? '官方' : '未知用户') }}
        </p>
      </div>
    </div>
  </div>
</template>

<script setup lang="ts">
import { computed, ref, watch } from 'vue'
import { AppButton } from '@/components/common'
import { getAppCoverUrl, getUserAvatarUrl } from '@/utils/imageUrl'

interface Props {
  app: API.AppVO
  featured?: boolean
}

interface Emits {
  (e: 'view-chat', appId: string | number | undefined): void
  (e: 'view-work', app: API.AppVO): void
}

const props = withDefaults(defineProps<Props>(), {
  featured: false,
})

const emit = defineEmits<Emits>()

const coverLoadFailed = ref(false)

watch(
  () => props.app.cover,
  () => {
    coverLoadFailed.value = false
  },
)

const displayCover = computed(() => {
  if (coverLoadFailed.value) {
    return ''
  }
  return getAppCoverUrl(props.app)
})

const userAvatar = computed(() => getUserAvatarUrl(props.app.user?.userAvatar))

const handleCoverError = () => {
  coverLoadFailed.value = true
}

const handleViewChat = () => {
  emit('view-chat', props.app.id)
}

const handleViewWork = () => {
  emit('view-work', props.app)
}
</script>

<style scoped>
.app-card {
  background: var(--color-bg-elevated);
  border-radius: var(--radius-xl);
  overflow: hidden;
  box-shadow: var(--shadow-card);
  backdrop-filter: var(--backdrop-blur);
  border: 1px solid var(--color-border-light);
  transition:
    transform var(--transition-normal),
    box-shadow var(--transition-normal);
  cursor: pointer;
}

.app-card:hover {
  transform: translateY(-8px);
  box-shadow: var(--shadow-card-hover);
}

.app-card--featured {
  border-color: var(--color-border);
}

.app-preview {
  height: 180px;
  background: var(--color-bg-muted);
  display: flex;
  align-items: center;
  justify-content: center;
  overflow: hidden;
  position: relative;
}

.app-preview img {
  width: 100%;
  height: 100%;
  object-fit: cover;
}

.app-placeholder {
  font-size: 48px;
  color: var(--color-text-muted);
}

.app-overlay {
  position: absolute;
  top: 0;
  left: 0;
  right: 0;
  bottom: 0;
  background: var(--color-bg-overlay);
  display: flex;
  align-items: center;
  justify-content: center;
  opacity: 0;
  transition: opacity var(--transition-normal);
}

.app-card:hover .app-overlay {
  opacity: 1;
}

.app-info {
  padding: var(--spacing-md);
  display: flex;
  align-items: center;
  gap: var(--spacing-sm);
}

.app-info-left {
  flex-shrink: 0;
}

.app-info-right {
  flex: 1;
  min-width: 0;
}

.app-title {
  font-size: var(--font-size-md);
  font-weight: var(--font-weight-semibold);
  margin: 0 0 var(--spacing-xs);
  color: var(--color-text-primary);
  white-space: nowrap;
  overflow: hidden;
  text-overflow: ellipsis;
}

.app-author {
  font-size: var(--font-size-sm);
  color: var(--color-text-secondary);
  margin: 0;
  white-space: nowrap;
  overflow: hidden;
  text-overflow: ellipsis;
}
</style>
