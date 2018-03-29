import React, { Component } from 'react';
import {
    Button,
    Image,
    View,
    Text
} from 'react-native';

class ProfileScreen extends React.Component {
  static navigationOptions = {
    title: 'Profile',
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

module.exports = ProfileScreen