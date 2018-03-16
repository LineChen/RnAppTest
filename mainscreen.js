import React, {Component} from 'react';
import {
    Button,
    Image,
    View,
    Text
} from 'react-native';

class MainScreen extends React.Component {
  static navigationOptions = {
    title: 'Welcome',
  };

  render() {
    const { navigate } = this.props.navigation;
    return (
      <Button
        title="Go to Jane's profile"
        onPress={() =>
          navigate('Profile', { name: 'Jane' });
        }
      />
    );
  }
}

module.exports = MainScreen