import React, { Component } from 'react';
import {AppRegistry,
        DeviceEventEmitter,
        Alert, StyleSheet, Text, Button, View, Image} from 'react-native';

var {NativeModules} = require('react-native');
var UtilsModule = NativeModules.UtilsModule



class HelloWorld extends React.Component {


  async getAuth() {
    try {
      var {
        auth
      } = await UtilsModule.getAuth();
            Alert.alert(auth)
    } catch (e) {
      console.error(e);
    }
  }

  showShareDialog(){
    UtilsModule.showShareDialog('阿鸡沙雕', '阿鸡傻逼阿说的是', 'http://img.taopic.com/uploads/allimg/121019/234917-121019231h258.jpg', 'http://img.taopic.com/uploads/allimg/121019/234917-121019231h258.jpg');
  }

//学生视角-老师评价页面
  gotoTeacherAllEvaluation(){
    UtilsModule.navPush("jiayouxueba://com.xiaoyu.com.xueba/teacher/showAllComment?teacherId=21405");
  }

//班课群聊
   gotogroupChat(){
        UtilsModule.navPush("jiayouxueba://com.xiaoyu.com.xueba/im/groupChat?sessionId=110000");
   }

//课程回放
   gotoCourseReplay(){
        UtilsModule.navPush("jiayouxueba://com.xiaoyu.com.xueba/course/replay?courseId=100&courseType=commom-lesson");
   }

//学生-评价班课课程
   gotoSeriesCourseEvaluate(){
        UtilsModule.navPush("jiayouxueba://com.xiaoyu.com.xueba/classCourse/comment?courseId=551196");
   }

//查看老师详情，包括学生、老师视角
   gotoTeacherDetail(){
        UtilsModule.navPush("jiayouxueba://com.xiaoyu.com.xueba/teacher/detailInfo?teacherId=21405&detailSource=0");
   }

//进入班课教室
    gotoClassRoom(){
        UtilsModule.navPush("jiayouxueba://com.xiaoyu.com.xueba/lesson/classRoom?roomId=10&courseId=001");
    }


    applyFriend(){
        UtilsModule.applyFriend("14096", 0);
     }

//新版分享
    showShare(){
        UtilsModule.showShare("来自加油学霸的分享", '阿鸡沙雕', '阿鸡傻逼阿说的是', 'http://img.taopic.com/uploads/allimg/121019/234917-121019231h258.jpg', 'http://img.taopic.com/uploads/allimg/121019/234917-121019231h258.jpg');
    }

  render() {
    return (
      <View style={styles.container}>

        <Text style={styles.hello}>Hello, ooooo</Text>

        <Button
            onPress={this.getAuth}
            title="getAuth"
            color="#841584"
          />

          <Button
                onPress={this.showShareDialog}
                title="showShareDialog"
                color="#841584"
               />

               <Button
                     onPress={this.gotoTeacherAllEvaluation}
                     title="gotoTeacherAllEvaluation"
                     color="#841584"
                    />

              <Button
                onPress={this.gotogroupChat}
                title="gotogroupChat"
                color="#841584"
              />

              <Button
                    onPress={this.gotoCourseReplay}
                    title="gotoCourseReplay"
                    color="#841584"
                   />

                   <Button
                         onPress={this.gotoSeriesCourseEvaluate}
                         title="gotoSeriesCourseEvaluate"
                         color="#841584"
                        />

        <Button
                onPress={this.gotoTeacherDetail}
                title="gotoTeacherDetail"
                color="#841584"
              />

              <Button
                    onPress={this.gotoClassRoom}
                    title="gotoClassRoom"
                    color="#841584"
                   />

                  <Button
                        onPress={this.applyFriend}
                        title="applyFriend"
                        color="#841584"
                       />


                 <Button
                   onPress={this.showShare}
                   title="showShare"
                   color="#841584"
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

AppRegistry.registerComponent('ReactNativeApp', () => HelloWorld);
//module.exports = HelloWorld