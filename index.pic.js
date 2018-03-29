import React, { Component } from 'react';
import {AppRegistry,
        DeviceEventEmitter,
        Alert, StyleSheet, Text, Button, View, Image} from 'react-native';


class Pic extends React.Component {

    render() {
        return (
          <View style={styles.container}>

            <Text style={styles.hello}>m1111</Text>


            <Image
                source={require('./app/src/main/res/drawable-xhdpi/ic_share_wechat.png')}
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


AppRegistry.registerComponent('Pic', () => Pic);