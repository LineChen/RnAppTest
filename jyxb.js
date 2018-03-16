import React, { Component } from 'react';
import {AppRegistry,
        DeviceEventEmitter,
        Alert, StyleSheet, Text, Button, View, Image} from 'react-native';

var {NativeModules} = require('react-native');
var UtilsModule = NativeModules.UtilsModule



class HelloWorld extends React.Component {


  async getAuth() {
    try {
      var {
        auth
      } = await UtilsModule.getAuth();
            Alert.alert(auth)
    } catch (e) {
      console.error(e);
    }
  }

  showShareDialog(){
    UtilsModule.showShareDialog('阿鸡沙雕', '阿鸡傻逼阿说的是', 'http://img.taopic.com/uploads/allimg/121019/234917-121019231h258.jpg', 'http://img.taopic.com/uploads/allimg/121019/234917-121019231h258.jpg');
  }

  render() {
    return (
      <View style={styles.container}>

        <Text style={styles.hello}>Hello, ooooo</Text>

        <Button
            onPress={this.getAuth}
            title="getAuth"
            color="#841584"
          />

          <Button
                onPress={this.showShareDialog}
                title="showShareDialog"
                color="#841584"
               />

      </View>
    );
  }

}

var styles = StyleSheet.create({
  container: {
    flex: 1,
    justifyContent: 'center',
  },
  hello: {
    fontSize: 20,
    textAlign: 'center',
    margin: 10,
  },
});

//AppRegistry.registerComponent('ReactNativeApp', () => HelloWorld);
module.exports = HelloWorld