module.exports = {
    runtimeCompiler: true,
    productionSourceMap: false,
    outputDir : '../src/main/resources/static',

    devServer : {
        port : 3031,
        proxy : {
            '^/' : {
                target : 'http://localhost:8888',
                ws : true,
                changeOrigin : true
            }
        }
    },

    publicPath: process.env.NODE_ENV === 'production'
        ? './'
        : '/',

    transpileDependencies: [
      'vuetify'
    ]
}
