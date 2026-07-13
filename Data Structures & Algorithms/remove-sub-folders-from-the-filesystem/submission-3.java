class Solution {
    public List<String> removeSubfolders(String[] folders) {
        Arrays.sort(folders);
        //^this makes parent folders appear before their child folders 

        List<String> parentFolders = new ArrayList<>();

        for(String folder : folders) {
            if(parentFolders.size()>0) {
                String lastParentFolder = parentFolders.getLast();
                if(folder.startsWith(lastParentFolder+"/")) {
                    continue;
                } else {
                    parentFolders.add(folder);
                }
            } else {
                parentFolders.add(folder);
            }
        }

        return parentFolders;
    }
}