'use strict';

import React from 'react';
import {
    AppRegistry
} from 'react-native';

//前端支持
import App from './react-native-app/src/views';
import ClassCourse from './classcourse/react-native-app/src/views'

//前端支持

AppRegistry.registerComponent('ReactNativeApp', () => App);
AppRegistry.registerComponent('ClassCourse', () => ClassCourse);