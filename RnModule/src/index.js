
import React, { Component } from 'react';
import {AppRegistry,
        DeviceEventEmitter,
        Alert, StyleSheet, Text, Button, View, Image} from 'react-native';


class Big extends React.Component {

    render() {
        return (
          <View style={styles.container}>

            <Text style={styles.hello}>m1111</Text>
            <Text style={styles.hello}>hot fix</Text>
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                             <Text style={styles.hello}>hot fix</Text>
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

import App from './react-native-app/src/views';
import ClassCourse from './classcourse/react-native-app/src/views'



AppRegistry.registerComponent('Big', () => Big);
AppRegistry.registerComponent('ReactNativeApp', () => App);
AppRegistry.registerComponent('ClassCourse', () => ClassCourse);
AppRegistry.registerComponent('ReactNativeApp2', () => App);
AppRegistry.registerComponent('ClassCourse2', () => ClassCourse);
AppRegistry.registerComponent('ReactNativeApp3', () => App);
AppRegistry.registerComponent('ClassCourse3', () => ClassCourse);

