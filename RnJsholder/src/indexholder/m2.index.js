
import React, { Component } from 'react';
import {AppRegistry,
        DeviceEventEmitter,
        Alert, StyleSheet, Text, Button, View, Image} from 'react-native';


class M2 extends React.Component {

    render() {
        return (
          <View style={styles.container}>

            <Text style={styles.hello}>m2222</Text>

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

AppRegistry.registerComponent('m2', () => M2);
