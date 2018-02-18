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
            },
            {
                test: /\.css$/,
                loader: ExtractTextPlugin.extract({
                    fallback: "style-loader",
                    use: "css-loader",
                })
            },
            {
                test: /\.(jpe?g|png|gif|svg)$/,
                loader: 'url-loader',
                options: {
                    publicPath : '/static/',
                    name : 'images/[name].[ext]',
                    limit : 1
                }
            },
            {
                test: /\.ico$/,
                loader: 'file-loader',
                options: {
                    publicPath : '/static/',
                    name : '[name].[ext]',
                    limit : 1
                }
            },
            {
                test: /\.(eot|svg|ttf|woff|woff2)$/,
                loader: 'url-loader',
                options: {
                    publicPath : '/static/',
                    name : 'fonts/[name].[ext]',
                    limit : 1
                }
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
