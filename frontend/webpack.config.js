const path = require('path');

module.exports = {
    mode: "production",
    devtool: "source-map",
    entry: {
        'app':"./src/index.tsx",
    },
    output: {
        path: path.resolve(__dirname, './static/build'),
        filename: '[name]-bundle.js'
  },
    resolve: {
        extensions: [".ts", ".tsx", '.js']
    },

    module: {
        rules: [
            {
                test: /\.ts(x?)$/,
                exclude: /node_modules/,
                use: [
                    {
                        loader: "ts-loader"
                    }
                ]
            },
            {
                enforce: "pre",
                test: /\.js$/,
                loader: "source-map-loader"
            }
        ]
    },
     devServer: {
     contentBase: './static',
   },
};