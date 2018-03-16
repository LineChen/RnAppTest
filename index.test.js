import React, { Component } from 'react';
import {AppRegistry,
        DeviceEventEmitter,
        Alert, StyleSheet, Text, Button, View, Image} from 'react-native';

var {NativeModules} = require('react-native');
var ToastModule = NativeModules.ToastModule;

class Greeting extends Component {
  render() {
    return (
      <Text>Hello {this.props.name}!</Text>
    );
  }
}


class HelloWorld extends React.Component {

constructor(props){
  super(props);
}

componentWillMount(){
                       //监听事件名为EventName的事件
                    DeviceEventEmitter.addListener('studentEvent', function() {

                         alert("receive success");

                       });


}

  _onPressButton() {
    //Alert.alert('You tapped the button!')
    //ToastModule.show("_onPressButton", ToastModule.LONG);
//    ToastModule.testCallback(1, (msg) => {
//        ToastModule.show(msg, ToastModule.SHORT);
//    });
//   Alert.alert(this.state.property)
  }

   _onTestEvent() {
      ToastModule.testCallback(1, (msg) => {
          ToastModule.sendEvent1();
      });

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

    async testPromiseString() {
      try {
        var {
          msg
        } = await ToastModule.testPromiseString(100);
          ToastModule.show(msg, ToastModule.SHORT);
      } catch (e) {
        console.error(e);
      }
    }


//报错
//  _testPromise(){
//    ToastModule.testPromise(100)
//    .then((width) => {
//        ToastModule.show(width + ',' + height, ToastModule.SHORT);
//    })
//    .catch((e)){
//        Alert.alert(e);
//    }
//
//  }

  render() {
    return (
      <View style={styles.container}>

        <Text style={styles.hello}>{this.props.property}</Text>

        <Button
            onPress={this._onPressButton}
            title="Press Me"
            color="#841584"
          />

        <Button
            onPress={this._onTestEvent}
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

AppRegistry.registerComponent('RnTest', () => HelloWorld);