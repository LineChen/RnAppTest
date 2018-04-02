import React, { Component } from 'react';
import {
    Button,
    Image,
    View,
    Text
} from 'react-native';

class ThirdScreen extends React.Component {
  static navigationOptions = {
    title: 'ThirdScreen',
  };
  render() {
    const { navigate } = this.props.navigation;
    return (
      <Button
        title="kkkkkk"
//        onPress={() =>
//          navigate('Profile', { name: 'Jane' });
//        }
      />
    );
  }
}



module.exports = ThirdScreen