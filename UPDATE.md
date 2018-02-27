
1.在工程根目录下执行打包命令
react-native bundle --entry-file index.js --bundle-output ./app/src/main/assets/index.android.jsbundle --platform android --assets-dest ./app/src/main/res/ --dev false

2.增量升级
react-native bundle --entry-file index.js --bundle-output ./bundle/androidBundle/index.android.jsbundle --platform android --assets-dest ./bundle/androidBundle/ --dev false
