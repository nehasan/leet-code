from typing import List, Optional


class TreeNode:
    def __init__(self, val=0, left=None, right=None) -> None:
        self.val = val
        self.left = left
        self.right = right

class BTInorderTraversal:
    def inorderTraversal(self, root: Optional[TreeNode]) -> List[int]:
        nodeList = list()
        self.inorder(root, nodeList)

        return nodeList
    
    def inorder(self, node: Optional[TreeNode], nodeList: list=list()) -> None:
        if node:
            self.inorder(node.left, nodeList)
            
            nodeList.append(node.val)

            self.inorder(node.right, nodeList)


obj = BTInorderTraversal()

tree1 = TreeNode(2, TreeNode(1), TreeNode(3))
tree2 = TreeNode(1, TreeNode(5, TreeNode(4), TreeNode(2)), TreeNode(7))

print(obj.inorderTraversal(tree1))
print(obj.inorderTraversal(tree2))