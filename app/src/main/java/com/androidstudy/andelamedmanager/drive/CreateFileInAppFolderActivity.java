package com.androidstudy.andelamedmanager.drive;

public class CreateFileInAppFolderActivity {
//
//    @Override
//    protected void onDriveClientReady() {
//        createFileInAppFolder();
//    }
//
//    // [START create_file_in_appfolder]
//    private void createFileInAppFolder() {
//        final Task<DriveFolder> appFolderTask = getDriveResourceClient().getAppFolder();
//        final Task<DriveContents> createContentsTask = getDriveResourceClient().createContents();
//        Tasks.whenAll(appFolderTask, createContentsTask)
//                .continueWithTask(new Continuation<Void, Task<DriveFile>>() {
//                    @Override
//                    public Task<DriveFile> then(@NonNull Task<Void> task) throws Exception {
//                        DriveFolder parent = appFolderTask.getResult();
//                        DriveContents contents = createContentsTask.getResult();
//                        OutputStream outputStream = contents.getOutputStream();
//                        try (Writer writer = new OutputStreamWriter(outputStream)) {
//                            writer.write("Hello World!");
//                        }
//
//                        MetadataChangeSet changeSet = new MetadataChangeSet.Builder()
//                                .setTitle("MedManager")
//                                .setMimeType("text/plain")
//                                .setStarred(true)
//                                .build();
//
//                        return getDriveResourceClient().createFile(parent, changeSet, contents);
//                    }
//                })
//                .addOnSuccessListener(this,
//                        new OnSuccessListener<DriveFile>() {
//                            @Override
//                            public void onSuccess(DriveFile driveFile) {
//                                showMessage(getString(R.string.file_created,
//                                        driveFile.getDriveId().encodeToString()));
//                                finish();
//                            }
//                        })
//                .addOnFailureListener(this, new OnFailureListener() {
//                    @Override
//                    public void onFailure(@NonNull Exception e) {
//                        Timber.d("Unable to create file", e);
//                        showMessage(getString(R.string.file_create_error));
//                        finish();
//                    }
//                });
//    }
    // [END create_file_in_appfolder]
}
