<template>
  <div class="user-info">
    <a-avatar :src="avatarUrl || undefined" :size="size">
      {{ user?.userName?.charAt(0) || 'U' }}
    </a-avatar>
    <span v-if="showName" class="user-name">{{ user?.userName || '未知用户' }}</span>
  </div>
</template>

<script setup lang="ts">
import { computed } from 'vue'
import { getUserAvatarUrl } from '@/utils/imageUrl'

interface Props {
  user?: API.UserVO
  size?: number | 'small' | 'default' | 'large'
  showName?: boolean
}

const props = withDefaults(defineProps<Props>(), {
  size: 'default',
  showName: true,
})

const avatarUrl = computed(() => getUserAvatarUrl(props.user?.userAvatar))
</script>

<style scoped>
.user-info {
  display: flex;
  align-items: center;
  gap: var(--spacing-sm);
}

.user-name {
  font-size: var(--font-size-sm);
  color: var(--color-text-primary);
}
</style>
