import {
    StackNavigator,
} from 'react-navigation';

import {
    AppRegistry,
       } from 'react-native';

import MainScreen from './mainscreen'
import ProfileScreen from './profile'



const App = StackNavigator({
      Main: {screen: MainScreen},
      Profile: {screen: ProfileScreen},

    },
    {
        initialRouteName: 'Main'
    }
   );

AppRegistry.registerComponent('RnTest', () => App);



