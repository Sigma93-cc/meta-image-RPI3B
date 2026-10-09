FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:${THISDIR}/common:"

SRC_URI += "\
    file://${PANEL_KCONFIG_FRAG} \ 
    file://enable_spi.cfg \
" 