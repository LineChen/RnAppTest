#!/usr/bin/env bash

my_pwd=`pwd`

root=$my_pwd/RnJsholder/
#各个模块的index目录
index_dir=$my_pwd/RnJsholder/src/indexholder/

#jsbundle生成目录
root_build_dir=$my_pwd/RnJsholder/build/
jsbundle_dir_sufix=/jsbundle/
jspatch_dir_sufix=/jspatch/
##patch生成目录
#jspatch_build_dir=$my_pwd/RnJsholder/build/jspatch/
#
##jsbundle备份文件夹
root_bak_dir=$my_pwd/RnJsholder/bak/
##jspatch备文件夹
#jspatch_bak_dir=$my_pwd/RnJsholder/bak/jspatch/

#jsbundle输出路径,默认是./app/src/main/assets/
jsbundle_output_folder=$my_pwd/app/src/main/assets/

settings=$my_pwd/RnJsholder/settings.json

#jsbundle文件后缀
jsbundle_sufix=.android.jsbundle
module_index_sufix=.index.js



#1、根据指定index文件目录，遍历目录,生成各个index文件对应的jsbundle
    if [ ! -d ${index_dir} ];then
        echo "非法目录"
        exit
    fi

    cat $settings | jq -c -r ".[]" | while read row
    do
        _jq() {
            echo ${row} | jq -r ${1}
        }
        module_name=`_jq '.moduleName'`
        module_version=`_jq '.moduleVersion'`
        min_appversion=`_jq '.minAppVersion'`

        js_entry_file=$index_dir$module_name$module_index_sufix
        js_output_file=$jsbundle_output_folder$module_name$jsbundle_sufix

        if [ ! -f ${js_entry_file} ];then
            echo "${js_entry_file}不存在"
        else
             #生成jsbundle
            echo -e "\t模块${module_name}构建中"
            react-native bundle --entry-file ${js_entry_file} --bundle-output ${js_output_file} --platform android --assets-dest ./app/src/main/res/ --dev false

            #保存一份到build目录下
            jsbundle_build_dir=$root_build_dir$min_appversion$jsbundle_dir_sufix

            module_jsbundle_build_dir=$jsbundle_build_dir$module_name
            if [ ! -d ${module_jsbundle_build_dir} ];then
                mkdir -p ${module_jsbundle_build_dir}
            fi
            build_file=${module_jsbundle_build_dir}"/"${module_name}${jsbundle_sufix}"_"${module_version}
            cp ${js_output_file} ${build_file}
            echo -e "\t模块${module_name}构建成功"

#            #备份jsbundle
#            jsbundle_bak_dir=$root_bak_dir$min_appversion$jsbundle_dir_sufix
#            module_bundle_bak_dir=$jsbundle_bak_dir$module_name
#            if [ ! -d ${module_bundle_bak_dir} ];then
#                mkdir -p ${module_bundle_bak_dir}
#            fi
#            bak_file=${module_bundle_bak_dir}"/"${module_name}${jsbundle_sufix}"_"${module_version}
#            cp ${js_output_file} ${bak_file}
#            echo -e "\t模块${module_name} jsbundle备份至$bak_file"

            #生成模块对应的patch文件夹c
            jspatch_build_dir=$root_build_dir$min_appversion$jspatch_dir_sufix
            module_patch_dir=$jspatch_build_dir$module_name
            if [ ! -d ${module_patch_dir} ];then
                mkdir -p ${module_patch_dir}
            fi
        fi
    done

#     java -jar jsbundlepatch.jar -p  ${root_build_dir}
#     java -jar jsbundlepatch.jar -j  ${root_build_dir}

      #备份文件
     if [ ! -d ${root_bak_dir} ];then
                mkdir -p ${root_bak_dir}
            fi
     cp -r ${root_build_dir} ${root_bak_dir}

