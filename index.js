import React from 'react';
import {AppRegistry, Alert, StyleSheet, Text, Button, View} from 'react-native';

var {NativeModules} = require('react-native');
var ToastModule = NativeModules.ToastModule;

class HelloWorld extends React.Component {

  _onPressButton() {
    //Alert.alert('You tapped the button!')
    //ToastModule.show("_onPressButton", ToastModule.LONG);
    ToastModule.testCallback(1, (msg) => {
        ToastModule.show(msg, ToastModule.SHORT);
    });

//    this.testPromise();
  }

  async testPromise() {
    try {
      var {
        width,
        height
      } = await ToastModule.testPromise(100);
        ToastModule.show(width + "," + height, ToastModule.SHORT);
    } catch (e) {
      console.error(e);
    }
  }

  render() {
    return (
      <View style={styles.container}>
        <Text style={styles.hello}>Hello, c4444</Text>

        <Button
            onPress={this.testPromise}
            title="Press Me"
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

AppRegistry.registerComponent('MyReactNativeApp', () => HelloWorld);