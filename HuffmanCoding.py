from typing import Any


class node:
    def __init__(self, freq, symbol, left=None, right=None):
        self.freq = freq
        self.symbol = symbol
        self.left = left
        self.right = right
        self.huff = ''

class HuffmanCoding:

    dic ={}
    def printNodes(node, val=''):
        newVal = val + str(node.huff)
        if(node.left):
            HuffmanCoding.printNodes(node.left, newVal)
        if(node.right):
            HuffmanCoding.printNodes(node.right, newVal)
        if(not node.left and not node.right):
            HuffmanCoding.dic[node.symbol] = newVal
        return HuffmanCoding.dic

    #def build(self, text : str):
    def build(self, text : str) -> Any:
        d = {}
        for char in text:
            if char in d:
                d[char]+=1
            else:
                d[char] = 1
        chars = list(d.keys())
        freq = list(d.values())
        nodes = []
        for x in range(len(chars)):
            nodes.append(node(freq[x], chars[x]))
        while len(nodes) > 1:
            nodes = sorted(nodes, key=lambda x: x.freq)
            left = nodes[0]
            right = nodes[1]
            left.huff = 0
            right.huff = 1
            newNode = node(left.freq+right.freq, left.symbol+right.symbol, left, right)
            nodes.remove(left)
            nodes.remove(right)
            nodes.append(newNode)
        xyz = HuffmanCoding.printNodes(nodes[0], val = '')
        return xyz
    #def encode(self, Dic, text : str) -> str:
    def encode(self, Dic : Any, text : str) -> str:
        out = ''
        for ch in text:
            out += Dic[ch]
        return out
    #def decode(self, Dic, text : str) -> str:
    def decode(self, Dic : Any, text : str) -> str:
        char = list(Dic.keys())
        encd = list(Dic.values())
        dec = ''
        i=0
        while len(text):
            if text[0:i] in encd:
                dec += char[encd.index(text[0:i])]
                text = text[i:]
                i=0
            i+=1
        return dec
