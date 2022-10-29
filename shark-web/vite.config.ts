import { UserConfigExport, ConfigEnv } from 'vite';

import { viteMockServe } from 'vite-plugin-mock';
import vue from '@vitejs/plugin-vue';
import { defineConfig } from 'vite'
import AutoImport from 'unplugin-auto-import/vite'
import Components from 'unplugin-vue-components/vite'
import { ElementPlusResolver } from 'unplugin-vue-components/resolvers'

export default ({ command }: ConfigEnv): UserConfigExport => {
    return {
        plugins: [
            vue(),
            viteMockServe({
                mockPath: 'mock',
                localEnabled: command === 'serve',
            }),
            AutoImport({
                resolvers: [ElementPlusResolver()],
            }),
            Components({
                resolvers: [ElementPlusResolver()],
            }),
        ],
        server: {
            port : 3001,
            proxy: {
                '/blackshark': {
                    target: 'http://localhost:1009/blackshark',
                    changeOrigin: true,
                    rewrite: path => path.replace(/^\/blackshark/, '')
                }
            }
        },
    };
};





