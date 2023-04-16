# from logging.config import valid_ident
# from turtle import left
from typing import Optional


# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class IsSameTree:
    def isSameTree(self, p: Optional[TreeNode], q: Optional[TreeNode]) -> bool:
        # print("P VAL: {}" )
        if p == None and q == None:
            return True
        elif p != None or q != None:
            return False
        else:
            if p.val == q.val:
                return self.isSameTree(p.left, q.left) and self.isSameTree(p.right, q.right)
            else:
                return False


obj = IsSameTree()
t1 = TreeNode(1, TreeNode(2), TreeNode(3))
t2 = TreeNode(1, TreeNode(2), TreeNode(3))

print(obj.isSameTree(t1, t2))