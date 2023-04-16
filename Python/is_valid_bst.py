from typing import Optional

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class IsValidBST:
    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        return self.validate(root, [])
    
    def validate(self, node: Optional[TreeNode], inorder_list: list=[]) -> bool:
        if node is None:
            return True
        
        if self.validate(node.left, inorder_list) is False:
            return False

        if inorder_list and node.val <= inorder_list[-1]:
            return False

        inorder_list.append(node.val)
        return self.validate(node.right, inorder_list)



obj = IsValidBST()
tree = TreeNode(2, TreeNode(1), TreeNode(3))

print(obj.isValidBST(tree))