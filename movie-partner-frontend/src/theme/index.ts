import type { ThemeConfig } from 'ant-design-vue/es/config-provider/context'

export const antdTheme: ThemeConfig = {
  token: {
    colorPrimary: '#6b9e78',
    colorSuccess: '#6aab72',
    colorWarning: '#c4a35a',
    colorError: '#c97b7b',
    colorInfo: '#6a9eaa',
    colorTextBase: '#3d5247',
    colorBgContainer: '#f5faf7',
    colorBgLayout: '#eef5f0',
    colorBorder: '#d8e5dc',
    borderRadius: 8,
    borderRadiusLG: 12,
    fontFamily:
      "-apple-system, BlinkMacSystemFont, 'Segoe UI', 'Roboto', 'Oxygen', 'Ubuntu', 'Cantarell', 'Fira Sans', 'Droid Sans', 'Helvetica Neue', sans-serif",
    fontSize: 14,
    controlHeight: 36,
  },
  components: {
    Button: {
      borderRadius: 8,
      controlHeight: 36,
    },
    Card: {
      borderRadiusLG: 12,
    },
    Modal: {
      borderRadiusLG: 12,
    },
    Input: {
      borderRadius: 8,
    },
  },
}
