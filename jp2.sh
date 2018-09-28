#!/usr/bin/env bash

my_pwd=`pwd`

#各个模块的index目录
src_dir=$my_pwd/RnModule/src/

#生成目录
root_build_dir=$my_pwd/RnModule/build/

jsbundle_dir_sufix=/jsbundle/
jspatch_dir_sufix=/jspatch/


#备份文件夹
root_bak_dir=$my_pwd/RnModule/bak/
#jsbundle输出路径,默认是./app/src/main/assets/
jsbundle_output_dir=$my_pwd/app/src/main/assets/
jsbundle_assets_dest=$my_pwd/app/src/main/res/


settings=$my_pwd/RnModule/settings.json

#jsbundle文件后缀
jsbundle_sufix=.android.jsbundle
#module_index_sufix=.index.js



#1、根据指定index文件目录，遍历目录,生成各个index文件对应的jsbundle
#    if [ ! -d ${src_dir} ];then
#        echo "没有源文件"
#        exit
#    fi
#
#    cat $settings | jq -c -r ".[]" | while read row
#    do
#        _jq() {
#            echo ${row} | jq -r ${1}
#        }
#        bundle_name=`_jq '.bundleName'`
#        bundle_version=`_jq '.bundleVersion'`
#        min_appversion=`_jq '.minAppVersion'`
#        indexPath=`_jq '.indexPath'`
#
#        js_entry_file=$src_dir$indexPath
#        js_output_file=$jsbundle_output_dir$bundle_name$jsbundle_sufix
#
#        if [ ! -f ${js_entry_file} ];then
#            echo "${js_entry_file}不存在"
#        else
#             #生成jsbundle
#            echo -e "\t模块${bundle_name}构建中"
#            react-native bundle --entry-file ${js_entry_file} --bundle-output ${js_output_file} --platform android --assets-dest ${jsbundle_assets_dest} --dev false
#
#            #保存一份到build目录下
#            jsbundle_build_dir=$root_build_dir$bundle_name$jsbundle_dir_sufix$min_appversion
#
#            module_jsbundle_build_dir=$jsbundle_build_dir
#            if [ ! -d ${module_jsbundle_build_dir} ];then
#                mkdir -p ${module_jsbundle_build_dir}
#            fi
#            build_file=${module_jsbundle_build_dir}"/"${bundle_name}${jsbundle_sufix}"_"${bundle_version}
#            cp ${js_output_file} ${build_file}
#            echo -e "\t模块${bundle_name}构建成功"
#
#            #生成模块对应的patch文件夹c
#            jspatch_build_dir=$root_build_dir$bundle_name$jspatch_dir_sufix
#            module_patch_dir=$jspatch_build_dir
#            if [ ! -d ${module_patch_dir} ];then
#                mkdir -p ${module_patch_dir}
#            fi
#        fi
#    done

     java -jar jp2.jar -p  ${root_build_dir}
     java -jar jp2.jar -j  ${root_build_dir} -pre

          #备份文件
#     if [ ! -d ${root_bak_dir} ];then
#                mkdir -p ${root_bak_dir}
#            fi
#     cp -r ${root_build_dir} ${root_bak_dir}