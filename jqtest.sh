#!/usr/bin/env bash
bakfile=`pwd`/setting_bak.txt

json=`jq . ./RnModule/settings.json`
echo $json

#arr=($(jq -r '.[]' android_jsbundle_patch_build.json))
#printf '%s\n' "${arr[@]}"

#遍历json数组
#写法1
for row in $(echo "${json}" | jq -r '.[] | @base64'); do
    _jq() {
     echo ${row} | base64 --decode | jq -r ${1}
    }

    moduleName=`_jq '.bundleName'`
    moduleVersion=`_jq '.bundleVersion'`
    minAppVersion=`_jq '.minAppVersion'`
    message=`_jq '.message'`
    echo "${moduleName} , ${moduleVersion}"

#   echo "$(_jq '.moduleName'), $(_jq '.moduleVersion'), $(_jq '.minAppVersion'), $(_jq '.message')"
done

echo $json > $bakfile

#写法2
#cat test.json | jq -c -r ".[]" | while read row
#do
#    _jq() {
#        echo ${row} | jq -r ${1}
#    }
#
#    echo "$(_jq '.moduleName'), $(_jq '.moduleVersion'), $(_jq '.minAppVersion'), $(_jq '.message')"

#done