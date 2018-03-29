
1.在工程根目录下执行打包命令
react-native bundle --entry-file index.js --bundle-output ./app/src/main/assets/index.android.jsbundle --platform android --assets-dest ./app/src/main/res/ --dev false


test:
react-native bundle --entry-file index.m1.js --bundle-output ./app/src/main/assets/m1.android.jsbundle --platform android --assets-dest ./app/src/main/res/ --dev false

react-native bundle --entry-file index.m2.js --bundle-output ./app/src/main/assets/m2.android.jsbundle --platform android --assets-dest ./app/src/main/res/ --dev false

react-native bundle --entry-file ./SRC/navigator.test.js --bundle-output ./app/src/main/assets/index.android.jsbundle --platform android --assets-dest ./app/src/main/res/ --dev false

react-native bundle --entry-file ./RnJsholder/src/indexholder/index.m1.js --bundle-output ./app/src/main/assets/m1.android.jsbundle --platform android --dev false


react-native bundle --entry-file index.pic.js --bundle-output ./app/src/main/assets/index.android.jsbundle --platform android --assets-dest ./app/src/main/res --dev false


2.增量升级
react-native bundle --entry-file index.js --bundle-output ./bundle/androidBundle/index.android.jsbundle --platform android --assets-dest ./bundle/androidBundle/ --dev false


#### 升级 react native 步骤 ####
refer http://www.2cto.com/kf/201601/486196.html

1. react-native --version  查看当前版本

2. npm info react-native | grep 'dist-tags'  查看服务器最新版本
3. npm install --save react-native@最新版号   eg: npm install --save react-native@0.33.0

4. npm info react  查看服务器最新版本
5. npm install --save react@最新版号   eg: npm install --save react@15.3.2

5. react-native upgrade  更新 templates 文件
6. curl -o .flowconfig https://raw.githubusercontent.com/facebook/react-native/master/.flowconfig 更新 flowconfig 文件
