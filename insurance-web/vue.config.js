const CompressionPlugin = require('compression-webpack-plugin');

module.exports = {
    devServer: {
        host: '0.0.0.0',
        port: 8080,
        proxy: {
            '/ins': {
                target: 'http://127.0.0.1:8099',
                ws: true
            }
        }
    },
    productionSourceMap: false,
    configureWebpack: {
        plugins: [
            new CompressionPlugin({
                test: /\.js$|\.html$|\.css/,
                threshold: 10240
            })
        ]
    }
}
