<template>
  <div class="app-sidebar sidebar-shadow" @mouseover="toggleSidebarHover('add','closed-sidebar-open')" @mouseleave="toggleSidebarHover('remove','closed-sidebar-open')">
    <div class="app-header__logo">
      <div class="logo-src"/>
      <div class="header__pane ml-auto">
        <button type="button" class="hamburger close-sidebar-btn hamburger--elastic" v-bind:class="{ 'is-active' : isOpen }" @click="toggleBodyClass('closed-sidebar')">
                    <span class="hamburger-box">
                        <span class="hamburger-inner"></span>
                    </span>
        </button>
      </div>
    </div>
    <div class="app-sidebar-content">
      <VuePerfectScrollbar class="app-sidebar-scroll" v-once>
        <sidebar-menu showOneChild :menu="menu"/>
      </VuePerfectScrollbar>
    </div>

  </div>
</template>