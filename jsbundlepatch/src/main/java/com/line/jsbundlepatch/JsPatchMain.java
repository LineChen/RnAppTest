package com.line.jsbundlepatch;

import com.line.jsbundlepatch.utils.FileUtils;
import com.line.jsbundlepatch.utils.Log;
import com.line.jsbundlepatch.utils.PatchUtils;

import java.io.File;
import java.util.Arrays;
import java.util.Comparator;

public class JsPatchMain {

	private static final String TAG = "JsPatchMain";

	private interface Function{
		String CREATE_PATCH = "-p";
		String CREATE_JSON = "-j";
	}

	private static final String JSBUNDLE_DIR = "jsbundle";
	private static final String JSPATCH_DIR = "jspatch";

	public static void main(String[] args) {
//		if(args.length < 2) {
//			Log.log(TAG, "args:" + Arrays.toString(args));
//			return;
//		}
//		String function = args[0];
//		String buildRootDir = args[1];

		//test
		String function = "-j";
		String buildRootDir = "/Users/chenliu/studyApp/RnAppTest/RnJsholder/build/";

		if(Function.CREATE_PATCH.equals(function)){
			createPatch(buildRootDir);
		} else if(Function.CREATE_JSON.equals(function)){
//			createJson(buildRootDir);
		}

	}

	private static void createPatch(String buildRootDirPath) {
		try{
			File buildRootDir = new File(buildRootDirPath);
			File[] appVersionDirList = buildRootDir.listFiles();//app version
			if(appVersionDirList == null || appVersionDirList.length == 0) return;
			for (File versoinDir : appVersionDirList) {
				File jsbundleDir = new File(versoinDir, JSBUNDLE_DIR);
				File jspatchDir = new File(versoinDir, JSPATCH_DIR);
				File[] moduleDirs = jsbundleDir.listFiles();//modules
				if(moduleDirs != null && moduleDirs.length > 0){
					patch(jspatchDir, moduleDirs);
				}
			}
		}catch (Exception e){
			Log.log(TAG, e.getMessage());
		}
	}

	private static void patch(File jspatchDir, File[] moduleDirs) {
		for(File mDir : moduleDirs) {
            if(mDir.exists() && mDir.isDirectory()) {
                String moduleName = mDir.getName();
                File[] indexes = mDir.listFiles();
                if(indexes != null && indexes.length > 1) {
                    Arrays.sort(indexes, new Comparator<File>() {
                        @Override
                        public int compare(File o1, File o2) {
                            return o1.getName().compareTo(o2.getName());
                        }
                    });
                    for(int j = 1; j < indexes.length; j++) {
                        File lastFile = indexes[j - 1];
                        File curFile = indexes[j];
                        String patchName = PatchUtils.getPatchName(moduleName, lastFile.getName(), curFile.getName());
                        String patchPath = jspatchDir.getAbsolutePath() + File.separator + moduleName + File.separator + patchName ;
                        if(!FileUtils.exists(patchPath))
                            PatchUtils.patch(lastFile.getAbsolutePath(), curFile.getAbsolutePath(), patchPath);
                    }
                }
            }
        }
	}

//	private static void createJson(String buildRootDirPath){
//		try{
//			List<JsBundleHotFix> jsBundleHotFixes = new ArrayList<>();
//			File buildRootDir = new File(buildRootDirPath);
//			File[] appVersionDirList = buildRootDir.listFiles();//app version
//			if(appVersionDirList != null && appVersionDirList.length > 0){
//				for (File versoinDir : appVersionDirList) {
//					JsBundleHotFix fix = new JsBundleHotFix();
//					fix.setMinAppVersion(versoinDir.getName());
//					List<Module> moduleList = new ArrayList<>();
//					fix.setModuleList(moduleList);
//					File jsbundleDir = new File(versoinDir, JSBUNDLE_DIR);
//					File jspatchDir = new File(versoinDir, JSPATCH_DIR);
//
//					File[] moduleDirs = jsbundleDir.listFiles();//modules
//					if(moduleDirs != null && moduleDirs.length > 0){
//						for (File mDir : moduleDirs) {
//							//jsbundles
//							String moduleName = mDir.getName();
//							Module module = new Module(moduleName);
//							File[] bundleFiles = mDir.listFiles();
//							if(bundleFiles != null && bundleFiles.length > 0){
//								//获取最新的版本
//								File latestBundleFile = bundleFiles[bundleFiles.length - 1];
//								JsBundle jsBundle = new JsBundle();
//								jsBundle.setName(latestBundleFile.getName());
//								jsBundle.setVersion(PatchUtils.getJsBundleVersion(latestBundleFile.getName()));
//								//TODO : 设置下载地址
//								jsBundle.setDownloadUrl("");
//
//								//获取该模块所有的patch文件
//								File modulePatchDir = new File(jspatchDir, moduleName);
//								List<JsBundlePatch> jsBundlePatches = new ArrayList<>();
//								File[] patchList = modulePatchDir.listFiles();
//								if(patchList != null && patchList.length > 0){
//									for (File patch : patchList) {
//										JsBundlePatch jsBundlePatch = new JsBundlePatch();
//										jsBundlePatch.setName(patch.getName());
//										jsBundlePatch.setVersion(PatchUtils.getPatchVersion(patch.getName()));
//										//TODO : 设置下载地址
//										jsBundlePatch.setDownloadUrl("");
//										jsBundlePatches.add(jsBundlePatch);
//									}
//								}
//								module.setLatestBundle(jsBundle);
//								module.setJsBundlePatches(jsBundlePatches);
//							}
//							moduleList.add(module);
//						}
//					}
//				}
//			}
//
//			String bundle_patch_json = JSON.toJSONString(jsBundleHotFixes);
//			FileUtils.createFile(buildRootDirPath + File.separator + "bundle_patch_build.json", bundle_patch_json);
//		}catch (Exception e){
//			Log.log(TAG, e.getMessage());
//		}
//	}

}
