# ANDROID_CodingUI
LayoutParams
-----------
LayoutParams are used by views to tell their parents how they want to be laid out. See ViewGroup Layout Attributes for a list of all child view attributes that this class supports.
The base LayoutParams class just describes how big the view wants to be for both width and height. For each dimension, it can specify one of:
FILL_PARENT (renamed MATCH_PARENT in API Level 8 and higher), which means that the view wants to be as big as its parent (minus padding)
WRAP_CONTENT, which means that the view wants to be just big enough to enclose its content (plus padding)
an exact number
There are subclasses of LayoutParams for different subclasses of ViewGroup. For example, AbsoluteLayout has its own subclass of LayoutParams which adds an X and Y value.

ScreenShots
-----------
<div>
<img width="200" src="https://user-images.githubusercontent.com/32612534/40607984-5677f35a-626a-11e8-9e8f-aebce38be1c0.png">
</div>
