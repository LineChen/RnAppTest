import React, { Component } from 'react';
import {
    Button,
    Image,
    View,
    Text,
    StyleSheet
} from 'react-native';

class ProfileScreen extends React.Component {
  static navigationOptions = {
    title: 'Profile',
  };
  render() {
    const { navigate } = this.props.navigation;
    const {params} = this.props.navigation.state;
    return (

        <View style={styles.container}>

        <Text style={styles.hello}>pageId = {params.pageId}</Text>

        <Text style={styles.hello}>pageName = {params.pageName}</Text>

        <Button
            title="goBack"
            onPress={() => this.props.navigation.goBack()}
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


module.exports = ProfileScreen