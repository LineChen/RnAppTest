#!/usr/bin/env bash

#各个模块的index目录
index_folder=./RnJsholder/src/indexholder/

#jsbundle备份文件夹
bak_jsbundle_folder=./RnJsholder/bakJsbundle/

#jsbundle输出路径,默认是./app/src/main/assets/
jsbundle_output_folder=./app/src/main/assets/

#jsbundle文件后缀
jsbundle_sufix=.android.jsbundle

#jspatch备文件夹
bak_jspatch_folder=./RnJsholder/bakPatch/


#1、根据指定index文件目录，遍历目录,生成各个index文件对应的jsbundle
    if [ ! -d ${index_folder} ];then
        echo "非法目录"
        exit
    fi

    for file_a in ${index_folder}/*
    do
        temp_file=`basename $file_a`
        module_name=${temp_file%%.*}
        js_entry_file=$index_folder$temp_file
        js_output_file=$jsbundle_output_folder$module_name$jsbundle_sufix
        #echo "module_name: $module_name, js_entry_file $js_entry_file, js_output_file: $js_output_file"

        #生成jsbundle
        echo -e "\t模块${module_name}构建中"
        react-native bundle --entry-file ${js_entry_file} --bundle-output ${js_output_file} --platform android --assets-dest ./app/src/main/res/ --dev false
        echo -e "\t模块${module_name}构建成功"

        #备份jsbundle
        module_bundle_bak_folder=$bak_jsbundle_folder$module_name
        if [ ! -d ${module_bundle_bak_folder} ];then
            mkdir ${module_bundle_bak_folder}
        fi
        date=$(date +%Y%m%d%H%M%S)
        bak_file=${module_bundle_bak_folder}"/"${module_name}${jsbundle_sufix}"_"${date}
        cp ${js_output_file} ${bak_file}
        echo -e "\t模块${module_name} jsbundle备份成功"



    done
