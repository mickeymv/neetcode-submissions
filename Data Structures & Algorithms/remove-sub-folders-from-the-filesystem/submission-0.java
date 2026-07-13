class Solution {
    public List<String> removeSubfolders(String[] folders) {
        Set<String> folderSet = new HashSet<>();
        
        for(String folder : folders) {
            folderSet.add(folder);
        }

        List<String> parentFolders = new ArrayList<>();

        for(String folder : folders) {
            int indexOfLastSlash = folder.lastIndexOf("/");
            boolean isParentFolder = true;
            while(indexOfLastSlash!=0) {
                String parentFolder = folder.substring(0, indexOfLastSlash);
                if (folderSet.contains(parentFolder)) {
                    //do not add subFolder to the list 
                    isParentFolder=false;
                    break;
                }
                indexOfLastSlash = parentFolder.lastIndexOf("/");
            }
            if(isParentFolder) {
                parentFolders.add(folder);
            }
        }

        return parentFolders;
    }
}