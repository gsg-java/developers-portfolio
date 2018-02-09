const webpack = require('webpack');
const path = require('path');
const webpackMerge = require('webpack-merge');

const config = {
    entry: {
        App: path.resolve(__dirname, 'App.js')
    },
    output: {
        path: path.resolve(__dirname, 'src/main/resources/static'),
        filename: 'js/[name].js'
    },
    module: {
        rules: [
            {
                test: /\.js$/,
                exclude: /node_modules/,
                use: [{
                    loader: 'babel-loader',
                    options: {
                        presets: [
                            ['es2015', {modules: false}]
                        ]
                    }
                }]
            }
        ]
    },
    plugins : [
        new webpack.ProvidePlugin({
            $ : "jquery",
            jQuery : "jquery",
            Backbone : "backbone",
            _ : "underscore"
        })
    ]
};

module.exports = function(env) {
    return webpackMerge(config, require(`./webpack.${env}.js`));
};
