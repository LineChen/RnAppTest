#!/usr/bin/env bash

json=`jq . test.json`
#echo $json

arr=($(jq -r '.[]' test.json))
#printf '%s\n' "${arr[@]}"

#遍历json数组
#写法1
#for row in $(echo "${json}" | jq -r '.[] | @base64'); do
#    _jq() {
#     echo ${row} | base64 --decode | jq -r ${1}
#    }
#
#    moduleName=`_jq '.moduleName'`
#    moduleVersion=`_jq '.moduleVersion'`
#    minAppVersion=`_jq '.minAppVersion'`
#    message=`_jq '.message'`
#    echo "${moduleName} , ${moduleVersion}"
#
##   echo "$(_jq '.moduleName'), $(_jq '.moduleVersion'), $(_jq '.minAppVersion'), $(_jq '.message')"
#done

#写法2
cat test.json | jq -c -r ".[]" | while read row
do
    _jq() {
        echo ${row} | jq -r ${1}
    }

    echo "$(_jq '.moduleName'), $(_jq '.moduleVersion'), $(_jq '.minAppVersion'), $(_jq '.message')"

done