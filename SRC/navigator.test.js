import React, { Component } from 'react';

import {
    StackNavigator,
} from 'react-navigation';

import {
    AppRegistry,
       } from 'react-native';

import MainScreen from './mainscreen'
import ProfileScreen from './profile'



//const App = StackNavigator(
//    {
//      Main: {screen: MainScreen},
//      Profile: {screen: ProfileScreen},
//    },
//
//    {
//        initialRouteName: 'Profile',
//        initialRouteParams: { pageId: "kkk" }
//    }
//   );

   const AppView = () => (
    <App/>
   );

  class Navigation extends React.Component {
        render() {
        const App = StackNavigator(
            {
              Main: {screen: MainScreen},
              Profile: {screen: ProfileScreen},
            },

            {
                initialRouteName: 'Profile',
                initialRouteParams: {
                    pageId: this.props.params.pageId,
                    pageName: this.props.params.pageName
                 }
            }
           );
            return (
                <App/>
            );
          }
  }


AppRegistry.registerComponent('RnTest', () => Navigation);



