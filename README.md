# Hello series: A project to learn System UI
## What is it?
To explore how to show/hide Status bar and Navigation bar like below
> getActivity().getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM\_UI\_FLAG\_FULLSCREEN);

## What I do?
1. To summarize a little of knowledge about Status bar and Navigation bar like below
2. To show the different testing result with different flag
3. To create a simple app with ViewPager

## What I learn?
1. View.SYSTEM\_UI\_FLAG\_LAYOUT\_STABLE 固定window位置，不刷新页面
2. View.SYSTEM\_UI\_FLAG\_HIDE\_NAVIGATION 隐藏导航栏
3. View.SYSTEM\_UI\_FLAG\_FULLSCREEN 隐藏状态栏
4. View.SYSTEM\_UI\_FLAG\_VISIBLE 显示导航栏和状态栏
5. View.SYSTEM\_UI\_FLAG\_LIGHT\_NAVIGATION\_BAR 和 setNavigationBarColor(Color.TRANSPARENT) 设置状态栏透明
6. View.SYSTEM\_UI\_FLAG\_LIGHT\_STATUS\_BAR 和 setStatusBarColor(Color.TRANSPARENT) 设置导航栏透明
7. View.SYSTEM\_UI\_FLAG\_IMMERSIVE\_STICKY 彻底隐藏，不会因为屏幕的点击事件重新显示bar
