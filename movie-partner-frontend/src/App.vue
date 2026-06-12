<script setup lang="ts">
import { ConfigProvider } from 'ant-design-vue'
import BasicLayout from '@/layouts/BasicLayout.vue'
import { antdTheme } from '@/theme'
</script>

<template>
  <ConfigProvider :theme="antdTheme">
    <BasicLayout />
  </ConfigProvider>
</template>
