
import React, { Component } from 'react';
import {AppRegistry,
        DeviceEventEmitter,
        Alert, StyleSheet, Text, Button, View, Image} from 'react-native';


class M1 extends React.Component {

    render() {
        return (
          <View style={styles.container}>

            <Text style={styles.hello}>m1111</Text>
            <Text style={styles.hello}>m22222</Text>
            <Text style={styles.hello}>n3333d33</Text>

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

AppRegistry.registerComponent('m1', () => M1);
