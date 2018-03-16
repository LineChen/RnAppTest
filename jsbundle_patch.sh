#!/usr/bin/env bash

my_pwd=`pwd`

#各个模块的index目录
index_dir=$my_pwd/RnJsholder/src/indexholder/

#jsbundle生成目录
jsbundle_build_dir=$my_pwd/RnJsholder/build/jsbundle
#patch生成目录
jspatch_build_dir=$my_pwd/RnJsholder/build/jspatch

#jsbundle备份文件夹
jsbundle_bak_dir=$my_pwd/RnJsholder/bak/jsbundle/
#jspatch备文件夹
jspatch_bak_dir=$my_pwd/RnJsholder/bak/jspatch/

#jsbundle输出路径,默认是./app/src/main/assets/
jsbundle_output_folder=$my_pwd/app/src/main/assets/

#jsbundle文件后缀
jsbundle_sufix=.android.jsbundle



#1、根据指定index文件目录，遍历目录,生成各个index文件对应的jsbundle
    if [ ! -d ${index_dir} ];then
        echo "非法目录"
        exit
    fi

    for file_a in ${index_dir}/*
    do
        temp_file=`basename $file_a`
        module_name=${temp_file%%.*}
        js_entry_file=$index_dir$temp_file
        js_output_file=$jsbundle_output_folder$module_name$jsbundle_sufix

        #生成jsbundle
        echo -e "\t模块${module_name}构建中"
        react-native bundle --entry-file ${js_entry_file} --bundle-output ${js_output_file} --platform android --assets-dest ./app/src/main/res/ --dev false
        echo -e "\t模块${module_name}构建成功"

        #备份jsbundle
        module_bundle_bak_folder=$jsbundle_bak_dir$module_name
        if [ ! -d ${module_bundle_bak_folder} ];then
            mkdir -p ${module_bundle_bak_folder}
        fi
        date=$(date +%Y%m%d%H%M%S)
        bak_file=${module_bundle_bak_folder}"/"${module_name}${jsbundle_sufix}"_"${date}
        cp ${js_output_file} ${bak_file}
        echo -e "\t模块${module_name} jsbundle备份成功$bak_file"

        #生成模块对应的patch文件夹
        module_patch_folder=$jspatch_bak_dir$module_name
        if [ ! -d ${module_patch_folder} ];then
            mkdir -p ${module_patch_folder}
        fi

#        echo "bak_jsbundle_folder: $bak_jsbundle_folder "
#        echo "bak_jspatch_folder: $bak_jspatch_folder"
        java -jar jspatch.jar ${jsbundle_bak_dir} ${jspatch_bak_dir}

    done
